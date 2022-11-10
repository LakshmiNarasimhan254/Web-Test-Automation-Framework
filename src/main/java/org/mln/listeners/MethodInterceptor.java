package org.mln.listeners;

import org.mln.constants.FrameworkConstants;
import org.mln.utils.ExcelUtil;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance>executionList = new ArrayList<>();
        try {
            List<Map<String,String>> batchedata = ExcelUtil.getExcelRowDataAsMapList(FrameworkConstants.getRunmanagerpath(),FrameworkConstants.getRunmanagersheet());
            for(int methodIndex=0;methodIndex<methods.size();methodIndex++){
                for (Map<String,String>bData: batchedata) {
                    if(bData.get("TestName").equalsIgnoreCase(methods.get(methodIndex).getMethod().getMethodName())&&
                        (bData.get("Execute").equalsIgnoreCase("YES"))){
                            methods.get(methodIndex).getMethod().setInvocationCount(Integer.parseInt(bData.get("InvocationCount")));
                            methods.get(methodIndex).getMethod().setDescription(bData.get("TestDescription"));
                            executionList.add(methods.get(methodIndex));
                        }

                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return executionList;
    }
}
