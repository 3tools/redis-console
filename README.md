# redis-console
自动部署与监控redis控制台

## 功能
- 配置管理
  - server管理，默认用户名密码，各server用户
  - redis实例管理
- 状态监控
  - server状态监控
  - redis监控
  - 目前通过ssh登录服务器，前台从页面发起定时任务获取服务器健康状态，
    每次回去新打开一个网络连接，预计下一版本改成连接池实现


