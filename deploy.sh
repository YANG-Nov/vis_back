#!/usr/bin/env bash

target_user="root"
target_server="101.201.37.128"
target_port=22
target_path="/data/deploy"
script_name="vis_back.sh"

build_ok="none"
./gradlew clean
./gradlew build -x test && build_ok="ok"
echo "本地打包成功"

if [ "$build_ok"x = "ok"x ]; then
    echo "准备发布版本到远程"
    scp build/libs/visualization-1.0.0.jar ${target_user}@${target_server}:${target_path}
    scp ${script_name} ${target_user}@${target_server}:/usr/sbin/vis_back
    echo "创建备份版本"
    ssh ${target_user}@${target_server} "mkdir -p /data/deploy/backup"
    ssh ${target_user}@${target_server} "cp -p /data/deploy/visualization-1.0.0.jar /data/deploy/backup/visualization-1.0.0.jar.`date +%Y%m%d.%H%M%S`"
    ssh ${target_user}@${target_server} "vis_back restart";
    echo "版本发布完毕"
else
    echo "已中断部署"
fi

