###存包
* 1 Given 机器人管理1个储物柜且有空位，When 存放1个包， Then 存包成功并收到1个取包ticket
* 2 Given 机器人管理2个储物柜，第1个储物柜空置率为100%，第2个储物柜空置率为100%，When 存放1个包， Then 包被存在第1个储物柜并收到1个取包ticket
* 3 Given 机器人管理2个储物柜，第1个储物柜空置率为50%，第2个储物柜空置率为100%，When 存放1个包， Then 包被存在第2个储物柜并收到1个取包ticket
* 4 Given 机器人管理1个储物柜且无空位，When 机器人存放1个包， Then 机器人存包失败
###取包
* 5 Given 使用1个合法ticket, When 机器人取包, Then 机器人取包成功且对应的包被取出
* 6 Given 使用1个非法ticket, When 机器人取包，Then 机器人取包失败
* 7 Given 使用已被使用ticket, When 机器人取包， Then 机器人取包失败