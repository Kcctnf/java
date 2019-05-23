package com.xiaodong.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.rmi.server.ServerCloneException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author : dong
 * Time:2019/5/13
 */
public class QueryServlet extends HttpServlet {

    private Map<String, String> cityMap = new HashMap<String, String>();
    private Map<String, List<String>> scenicSpot = new HashMap<String, List<String>>();

    @Override
    public void init() throws ServletException {
        super.init();
        List<String> xian = new ArrayList<String>();
        xian.add("华清池");
        xian.add("兵马俑");
        xian.add("大雁塔");
        scenicSpot.put("xian", xian);
        cityMap.put("xian", "西安");

        List<String> baoJi = new ArrayList<String>();
        baoJi.add("太白山");
        baoJi.add("法门寺");
        baoJi.add("关山牧场");
        scenicSpot.put("baoJi", baoJi);
        cityMap.put("baoJi", "宝鸡");


        List<String> xianyang = new ArrayList<String>();
        xianyang.add("乾陵");
        xianyang.add("袁家村");
        scenicSpot.put("xianyang", xianyang);
        cityMap.put("xianyang", "咸阳");

    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServerException ,IOException {
        //处理参数
        String city = req.getParameter("city");
        //准备数据
        List<ScenicsDto> scenicsDtosArrayList = new ArrayList<ScenicsDto>();
        if(city == null || city.length() == 0){
            //全部
            for(Map.Entry<String,List<String>> entry : scenicSpot.entrySet()){
                String cityKey = entry.getKey();
                List<String> scenics = entry.getValue();
                for(String item : scenics){
                    ScenicsDto scenicsDto = new ScenicsDto();
                    scenicsDto.setCity(cityMap.get(cityKey));
                    scenicsDto.setName(item);
                    scenicsDtosArrayList.add(scenicsDto);
                }
            }
        }else{
            //单个城市
            List<String> scenics = scenicSpot.get(city);
            if(scenics == null){
                scenics = new ArrayList<String>();
            }
            for(String item : scenics){
                ScenicsDto scenicsDto = new ScenicsDto();
                scenicsDto.setCity(cityMap.get(city));
                scenicsDto.setName(item);
                scenicsDtosArrayList.add(scenicsDto);
            }
        }

        //响应数据
        resp.setContentType("text/html; charset = utf-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\n" +
                      "<html lang=\"en\">\n>" + "<head>\n" +
                      "<meta charset=\"utf-8\">\n" +
                      "<title>景点</title>\n" +
                      "</head>\n" +
                      "<body>\n" +
                      "<table>\n" +
                      "<thead>\n" +
                      "<tr>\n" +
                      "<td>编号</td>\n" +
                       "<td>所在城市</td>\n" +
                      "<td>景点名称</td>\n" +
                      "</tr>\n" +
                      "</thead>\n" +
                      "<tbody>");
        int id = 1;
        for(ScenicsDto dto : scenicsDtosArrayList){
            writer.append("<tr>").append("<td>").append(String.valueOf(id)).append("</td>")
                    .append("<td>").append(dto.city).append("</td>")
                    .append("<td>").append(dto.name).append("</td>").append("</tr>");
            id = id + 1;
        }
        writer.append("</tbody>\n" + "<table>\n" + "</body>\n" + "</html>");
    }
    public static class ScenicsDto{

        private String city;

        private String name;

        public String getCity() {
            return city;
        }

        public String getName() {
            return name;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
