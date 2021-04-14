#!/usr/bin/env bash

git_branch=`git branch|grep "\*"|awk -F" " '{print $2}'`
mode=""
if [ "$git_branch"x = "develop"x ]; then
    mode="dev"
elif [ "$git_branch"x = "test"x ]; then
    mode="test"
elif [ "$git_branch"x = "master"x ]; then
    mode="prod"
else
    echo "分支 $git_branch 发布到develop"
    mode="dev"
fi

if [ "$git_branch"x = "master"x ]; then
    read -p "请注意你正在发布"$git_branch"分支, 请确认(y/n): " choice
    if [ "$choice"x = "y"x ]; then
       echo "3s 后开始发布 $git_branch 分支"
       sleep 1
       echo "2s 后开始发布 $git_branch 分支"
       sleep 1
       echo "1s 后开始发布 $git_branch 分支"
       sleep 1
    else
      echo "已退出 $git_branch 发布"
      exit 1
    fi
fi

if [ "$mode"x = "dev"x ]; then
    target_user="root"
    target_server="139.9.157.89"
    target_port=22
    script_name="soms-dev.sh"
elif [ "$mode"x = "test"x ]; then
    target_user="root"
    target_server="139.9.157.89"
    target_port=22
    script_name="soms-dev.sh"
elif [ "$mode"x = "prod"x ]; then
    target_user="root"
    target_server="139.9.157.89"
    target_port=22
    script_name="soms-dev.sh"
fi

echo "发布模式 $mode, 分支 $git_branch"
echo ${target_server} ${target_port} ${target_user}

target_path="/data/deploy"

build_ok="none"
./gradlew clean
./gradlew build -x test && build_ok="ok"
echo "本地打包成功"

if [ "$build_ok"x = "ok"x ]; then
    echo "准备发布版本到远程"
    rsync -rz -P -e "ssh -p${target_port}" -r build/libs/soms-1.0.0.jar ${target_user}@${target_server}:${target_path}
    rsync -rz -P -e "ssh -p${target_port}" -r ${script_name} ${target_user}@${target_server}:/usr/sbin/soms
    ssh -p${target_port} ${target_user}@${target_server} "soms restart";
    echo "版本发布完毕"
else
    echo "已中断部署"
fi

