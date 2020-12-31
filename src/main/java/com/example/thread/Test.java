package com.example.thread;

import org.springframework.expression.spel.SpelCompilerMode;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author sunhu
 * @date 2020/10/14 10:56
 */
public class Test {

    public static void main(String[] args) {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("本日0点:"+sdf.format(getTime()));
//        System.out.println("本周一0点:"+sdf.format(getTimesWeekmorning()));
//        System.out.println("本月一日0点:"+sdf.format(getTimesMonthmorning()));
//        System.out.println("当前时刻:"+sdf.format(new Date()));
//        System.out.println("-------------");
//        testDivide();
//        TestDay();

    }


    /*两个日期之间所有日期
    可以直接显示，也可以返回List*/
    public static void getDates(String daysTmp) {
        // 获取当前日期
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        // 所有需要保留的日志日期
        List keepDates = new ArrayList();
        try {
            // 根据今天日期及保留天数，获取最大保留日期
            Calendar cal = Calendar.getInstance();
            // 获取当前日期
            cal.setTime(new Date());
            // 设置保留天数
            //log.error("系统默认保留日期为："+daysTmp);
            cal.add(Calendar.DATE, -Integer.parseInt(daysTmp));// 天数可正可负：88或者-88
            // 获取最大保留日期
            String oldDate = new SimpleDateFormat("yyyy-MM-dd").format(cal
                    .getTime());
            //log.error("当天日期：" + nowDate);
            //log.error("保留最大日期：" + oldDate);
            keepDates.add(oldDate);
            keepDates.add(nowDate);
            Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date startDate = df.parse(oldDate);
            startCalendar.setTime(startDate);
            Date endDate = df.parse(nowDate);
            endCalendar.setTime(endDate);
            while (true) {
                startCalendar.add(Calendar.DAY_OF_MONTH, 1);
                if (startCalendar.getTimeInMillis() < endCalendar
                        .getTimeInMillis()) {// TODO 转数组或是集合，楼主看着写吧
                    keepDates.add(df.format(startCalendar.getTime()));
                    // System.out.println(df.format(startCalendar.getTime()));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            //log.error("计算保留日期时出错，出错原因为NumberFormatException：" + e);
        }
        for(int i = 0;i<keepDates.size();i++){
            System.out.print(keepDates.get(i).toString());
            System.out.println();
        }
        //return keepDates;
    }


    public static void TestDay(){
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar=Calendar.getInstance();

        long next =calendar.getTimeInMillis();
        calendar.add(Calendar.MONTH,-1);
        while(calendar.getTimeInMillis()!=next)
        {
            System.out.println(calendar.getTime().toLocaleString());
            int w = calendar.get(Calendar.DAY_OF_WEEK)-1;
            if (w<0) {
                w=0;
            }
            System.out.println(weekDays[w]);
            int i=1;
            calendar.add(Calendar.DAY_OF_MONTH, i++);
        }
    }

    public static Date getTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,14);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println();
//
//        //当日0点
//        Calendar p1=Calendar.getInstance();
//        System.out.println(p1.getTime());
//        p1.set(Calendar.HOUR_OF_DAY,0);
//        p1.set(Calendar.MINUTE,0);
//        p1.set(Calendar.SECOND,0);
//        System.out.println("当日0点:"+p1.getTime());
////本周一0点
//        p1.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
//        System.out.println("本周一:"+p1.getTime());
////本月1日0点
//        p1.set(Calendar.DAY_OF_MONTH,1);
//        System.out.println("本月1日:"+p1.getTime());

        return cal.getTime();
    }


    // 获得本周一0点时间
    public static Date getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();


        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }


    // 获得本月第一天0点时间
    public static Date getTimesMonthmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }


    public static void testDivide(){

        BigDecimal total = new BigDecimal(25);
        BigDecimal divide1 = new BigDecimal(3).divide(total, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal divide2 = new BigDecimal(22).divide(total, 2, BigDecimal.ROUND_HALF_UP);
        DecimalFormat df = new DecimalFormat("00.00");

        System.out.println(new BigDecimal(100).multiply(divide1));
        System.out.println(df.format(divide2));
    }


    public static void getPeopeleOnline(){

//        {"data":{
//
//            "today":[
//            {"label":"CALLUP",
//                    "count":3,
//               }
//	            ],
//            "todayTotal":""
//          }
//        }
       Map resultMap = new HashMap();

        Map response = new HashMap();
        Map data= (Map)response.get("data");
        Integer todayTotal = Integer.valueOf(data.get("todayTotal").toString());
        List<Map<String, Object>> todayMap= (List<Map<String, Object>>) data.get("today");
        for (Map<String, Object> map : todayMap) {

            Integer count = Integer.valueOf(map.get("count").toString());
            map.put("value",count/todayTotal);
            map.remove("count");
        }
        resultMap.put("today",todayMap);

        Integer weekTotal = Integer.valueOf(data.get("weekTotal").toString());
        List<Map<String, Object>> weekListMap= (List<Map<String, Object>>) data.get("week");
        for (Map<String, Object> map : weekListMap) {
            Integer count = Integer.valueOf(map.get("count").toString());
            map.put("value",accuracy(count,weekTotal,2));
        }
        resultMap.put("week",weekListMap);


    }

    private static String accuracy(double num, double total, int scale) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracyNum = num / total * 100;
        return df.format(accuracyNum);
    }


    public static void getEmployee(){
        Map response = new HashMap();
        List<Map> employeeList = new ArrayList<>();
        List<Map> carList = new ArrayList<>();
        Map resultMap=new HashMap();
        List<Map<String, Object>> mapList= (List<Map<String, Object>>) response.get("data");


        int peopleTotal=0;
        int offlinePeopleTotal=0;
        int carTotal=0;
        int offlineCarTotal=0;

        for (Map<String, Object> map : mapList) {

            switch (map.get("label").toString()){
                case "人员数量":
                    peopleTotal=Integer.parseInt(map.get("value").toString());
                    employeeList.add(map);
                    break;
                case "未在岗范围":
                    map.put("label","未在岗");
                    offlinePeopleTotal=Integer.parseInt(map.get("value").toString());
                    employeeList.add(map);
                    break;
                case "车辆数量":
                    carTotal=Integer.parseInt(map.get("value").toString());
                    carList.add(map);
                    break;
                case "空闲范围":
                    offlineCarTotal=Integer.parseInt(map.get("value").toString());
                    carList.add(map);
                    break;
                default:break;
            }

           /* if ("人员数量".equals(map.get("label"))){
                 peopleTotal=Integer.parseInt(map.get("value").toString());
                employeeList.add(map);
            }
            if ("未在岗范围".equals(map.get("label"))){
                map.put("label","未在岗");
                offlinePeopleTotal=Integer.parseInt(map.get("value").toString());
                employeeList.add(map);
            }
            if ("车辆数量".equals(map.get("label"))){
                carTotal=Integer.parseInt(map.get("value").toString());
                carList.add(map);
            }
            if ("空闲范围".equals(map.get("label"))){
                offlineCarTotal=Integer.parseInt(map.get("value").toString());
                carList.add(map);
            }
*/
        }

        Map map1=new HashMap(4);
        map1.put("label","在岗");
        map1.put("value",peopleTotal-offlinePeopleTotal);
        employeeList.add(map1);

        Map map2=new HashMap(4);
        map2.put("label","在岗在位率");
        map2.put("value",(double)(peopleTotal-offlinePeopleTotal)/peopleTotal);
        employeeList.add(map2);


        Map map3=new HashMap(4);
        map3.put("label","在途");
        map3.put("value",carTotal-offlineCarTotal);
        carList.add(map3);

        Map map4=new HashMap(4);
        map4.put("label","在岗在位率");
        map4.put("value",(double)(peopleTotal-offlinePeopleTotal)/peopleTotal);
        carList.add(map2);

        resultMap.put("employeeList",employeeList);
        resultMap.put("carList",carList);

    }


    public static void getRiskArea(){
        Map response = new HashMap();
        List<Map<String, Object>> mapList= (List<Map<String, Object>>) response.get("data");


    }

    /**
     * 数组
     *
     * @param arr
     *            数组
     * @param sum
     *            总数
     * @param idx
     *            索引
     * @param precision
     *            精度
     * @return
     */
    public static double getPercentValue(Integer[] arr, double sum, int idx, int precision) {
        if ((arr.length - 1) < idx) {
            return 0;
        }
        int count = 0;
        // 10的2次幂是100，用于计算精度。
        double digits = Math.pow(10, precision);
        // 扩大比例100
        double[] votesPerQuota = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            double val = arr[i] / sum * digits * 100;
            votesPerQuota[i] = val;
        }
        // 总数,扩大比例意味的总数要扩大
        double targetSeats = digits * 100;
        // 再向下取值，组成数组
        double[] seats = new double[arr.length];
        for (int i = 0; i < votesPerQuota.length; i++) {
            seats[i] = Math.floor(votesPerQuota[i]);
        }
        // 再新计算合计，用于判断与总数量是否相同,相同则占比会100%
        double currentSum = 0;
        for (int i = 0; i < seats.length; i++) {
            currentSum += seats[i];
        }
        // 余数部分的数组:原先数组减去向下取值的数组,得到余数部分的数组
        double[] remainder = new double[arr.length];
        for (int i = 0; i < seats.length; i++) {
            remainder[i] = votesPerQuota[i] - seats[i];
        }
        while (currentSum < targetSeats) {
            double max = 0;
            int maxId = 0;
            int len = 0;
            for (int i = 0; i < remainder.length; ++i) {
                if (remainder[i] > max) {
                    max = remainder[i];
                    maxId = i;
                }
            }
            // 对最大项余额加1
            ++seats[maxId];
            // 已经增加最大余数加1,则下次判断就可以不需要再判断这个余额数。
            remainder[maxId] = 0;
            // 总的也要加1,为了判断是否总数是否相同,跳出循环。
            ++currentSum;
        }
        // 这时候的seats就会总数占比会100%
        return seats[idx] / digits;
    }


    /**
     * 收入数据处理，模拟今日 昨日数据差异
     *
     * @author sunhu
     * @date 2020/10/29 14:55
     * @param resultList
     *            结果
     * @param stationIncome:
     *            收入数据
     * @param mapHourParam:
     *            小时系数
     * @param weekParam:
     *            周系数
     * @param hourOfDay:
     *            小时数
     * @param random:
     * @return void
     */
    private void makeUpIncomeData(List<Map<String, Object>> resultList, List<Map<String, Object>> stationIncome,
                                  Map<Integer, BigDecimal> mapHourParam, BigDecimal weekParam, int hourOfDay, Random random) {
        for (int i = 0; i < stationIncome.size(); i++) {
            String name = (String)stationIncome.get(i).get("name");
            // 初始值
            BigDecimal initialValue = new BigDecimal(stationIncome.get(i).get("initial_value").toString());
            // 浮动值
            BigDecimal floatValue = new BigDecimal(stationIncome.get(i).get("float_value").toString());
            // 新增
            BigDecimal increase = new BigDecimal(stationIncome.get(i).get("increase").toString());
            BigDecimal range = floatValue.multiply(new BigDecimal("2"));
            BigDecimal sum = BigDecimal.ZERO;
            for (int y = 0; y < hourOfDay; y++) {
                BigDecimal hourParam = mapHourParam.get(y);
                if (BigDecimal.ZERO.compareTo(floatValue) != 0) {
                    double step = hourParam.doubleValue() * weekParam.doubleValue() * increase.doubleValue()
                            * (100d - floatValue.doubleValue() + random.nextInt(range.intValue())) / 100d;
                    sum = sum.add(new BigDecimal(step));
                } else {
                    double step = hourParam.doubleValue() * weekParam.doubleValue() * increase.doubleValue();
                    sum = sum.add(new BigDecimal(step));
                }
            }
            // 数据处理
            stationIncome.get(i).remove("name");
            stationIncome.get(i).remove("initial_value");
            stationIncome.get(i).remove("increase");
            stationIncome.get(i).remove("float_value");
            stationIncome.get(i).remove("gmt_create");
            stationIncome.get(i).put("label", name);
            stationIncome.get(i).put("value", initialValue.add(sum).setScale(2, BigDecimal.ROUND_HALF_DOWN));
            resultList.add(stationIncome.get(i));
        }
    }
}
