package tt1;


import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;


import sun.jvmstat.monitor.MonitorException;
import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.MonitoredVmUtil;
import sun.jvmstat.monitor.VmIdentifier;

public class ProcessID {

    public static void main(String[] args) throws Exception {
          int pid = getProcess("password");
         System.out.println("PID: "+pid);
    	System.out.println("ssss");
    }

    public static int getProcess(String name) throws MonitorException, URISyntaxException {
        if(name == null) {
            return -1;
        }

        // 获取监控主机
        MonitoredHost local = MonitoredHost.getMonitoredHost("localhost");
        // 取得所有在活动的虚拟机集合
        Set<?> vmlist = new HashSet<Object>(local.activeVms());
        // 遍历集合，输出PID和进程名
        for(Object process : vmlist) {
            MonitoredVm vm = local.getMonitoredVm(new VmIdentifier("//" + process));
            // 获取类名
            String processname = MonitoredVmUtil.mainClass(vm, true);
         //   MonitoredVmUtil.
         //   vm.
            if(name.equals(processname)) {
                System.out.println(((Integer)process).intValue());
               
            	//return ((Integer)process).intValue();
                
            }
        }
        return -1;
    }
}