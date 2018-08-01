# Bronze Grade Spring Cloud
## Ribbon
>+ 服务发现 
>+ 服务选择规则: 根据规则从多个服务中选择有效的服务 
>+ 服务监听：检测失效的服务，做到高效剔除
>+ 主要组件就是 ServerList IRule ServerListFilter。
其中先通过ServerList获得所有有效的服务列表，后通过ServerListFilter过滤掉部分地址，后通过IRule选择一个实例作为最终目标结果