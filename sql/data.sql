-- 表中已有数据的初始化，参照下面这三条sql来统一改
update t_component c set c.is_deleted = 0 where c.is_deleted is null;
update t_component c set c.create_time = now() where c.create_time is null;
update t_component c set c.update_time = now() where c.update_time is null;

-- 构建父子层级关系的sql，目前只支持4级，更多级别请在此基础上扩展
update t_component c
inner join
(
	select
		c1.id id1, c1.name name1, c1.parent_id pid1,
		c2.id id2, c2.name name2, c2.parent_id pid2,
		c3.id id3, c3.name name3, c3.parent_id pid3,
		c4.id id4, c4.name name4, c4.parent_id pid4,
		case
			when c4.name != c3.name then 3
			when c3.name != c2.name then 2
			when c2.name != c1.name then 1
			else 0
		end level,
		case
			when c4.name != c3.name then concat('/',c4.id,'/',c3.id,'/',c2.id,'/',c1.id)
			when c3.name != c2.name then concat('/',c3.id,'/',c2.id,'/',c1.id)
			when c2.name != c1.name then concat('/',c2.id,'/',c1.id)
			else concat('/',c1.id)
		end xpath,
		case
			when c4.name != c3.name then concat('/',c4.name,'/',c3.name,'/',c2.name,'/',c1.name)
			when c3.name != c2.name then concat('/',c3.name,'/',c2.name,'/',c1.name)
			when c2.name != c1.name then concat('/',c2.name,'/',c1.name)
			else concat('/',c1.name)
		end xname
	from t_component c1
	left join t_component c2 on c1.parent_id = c2.id
	left join t_component c3 on c2.parent_id = c3.id
	left join t_component c4 on c3.parent_id = c4.id
) a on c.id = a.id1
set c.level = a.level, c.xpath = a.xpath, c.xname = a.xname
;


-- 获取所有的叶子节点
select *
from t_component c
where
        (
            select count(1)
            from t_component i
            where i.parent_id = c.id
        ) = 0
;

-- 获取特定父亲的所有叶子节点
select *
from t_component c
where
        (
            select count(1)
            from t_component i
            where i.parent_id = c.id
        ) = 0
  and c.xpath like '%2001000006%'	-- parent_id 参数
;

-- 获取特定层级的节点
select *
from t_component c
where c.level = 1
order by c.id
;

