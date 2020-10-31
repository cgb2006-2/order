# cgb_order

订单配送项目

**管理员** 登录后, 可以对所有的表进行增删改操作,表基本信息见数据库;

1. 创建配送员角色,分配角色权限;

**配送员**	登录后, 只显示 **"我的信息"** , **"订单管理"** 功能模块: 可以的话, **"我的信息"** 页面是完整网页 , **"订单管理"** 使用模态框.

1. 要求完成前端回显配送员信息表,订单附表
2. 根据当前距离计算配送费
3. 订单页面有"我要接单"按钮,接单后开始计时,后端创建计时器,超时扣等额订单费
4. 订单页面有"订单送达"按钮,更改订单状态,重新计时,到时自动更新订单状态,给配送员"钱包"里打配送费.



## 初版分工:

1. 配送员登录之后,通过"/user/profile"可以在前端显示配送员自己的基本信息(罗浩, 陶小龙, 谢萌萌负责编写controller-service-mapper).

2. 配送员登陆之后,通过"/order/",可以在前端回显该配送员的订单历史(郑文健,蔡立成,彭宣霖,李牧原 负责编写controller-service-mapper).

   

## 数据库地址(局域网访问,使用数据库管理工具)

url:176.148.8.77:3306  

用户:root

密码:root


**自动修改工作状态:**
```java
@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;
	
	@Override
	public int saveObject(Activity entity) {
		// TODO Auto-generated method stub
		//System.out.println("entity.insert.before.id="+entity.getId());
		int rows=activityDao.insertObject(entity);
		//System.out.println("entity.insert.after.id="+entity.getId());
		//希望时间到了(endTime)自动修改活动状态
		//解决方案:基于任务调度去实现(任务调度-基于时间的设计自动执行任务)
		//代码方案:
		//1)借助Java中的Timer对象去实现
		Timer timer=new Timer();//此对象创建时会在底层启动一个线程,通过此线程对时间进行监控
		//2)执行任务(任务类型为TimerTask类型)
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				//在此位置修改活动的状态信息
				System.out.println("开始执行活动状态的修改操作");
				activityDao.updateState(entity.getId());
				timer.cancel();
			}
		}, entity.getEndTime());
		//2)借助Java线程池中的任务调度对象(ScheduledExecutorService )去实现
		//3)借助第三方框架去实现(quartz)
		return rows;
	
	}
```

**时间拦截器:**
```java
   public class TimeAccessInterceptor implements HandlerInterceptor {
    /**此方法在@Controller描述的对象方法执行之前执行
     * @return true表示请求放行,false表示请求到此结束.
     * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("==preHandler==");
		//获取当前时间(LocalDateTime为jdk8中的一个日历对象)
		LocalDateTime localDateTime=LocalDateTime.now();
		//获取当前时间对应的小时
		int hour=localDateTime.getHour();
		System.out.println("hour="+hour);
		if(hour<=6||hour>=23) 
			throw new ServiceException("请在9:00~18:00之间访问");
		return true;//true表示要执行后续拦截器方法或者目标@Controller对象方法
	}
```
