package org.lohas.bf.utils.img.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lohas on 2015/5/7.
 * https://github.com/lohasle
 * 图片服务处理队列
 */
public class ImgTaskQueue {

    ThreadLocal<List<ImgTask>> threadLocal = new ThreadLocal<>();

    List list = new ArrayList();

    public ImgTaskQueue(String imgSrc,String params) {
        //解析参数params
        //解析参数
        String[] imgServices = params.split("-");

        for (String imgService : imgServices) {
            String[] imgServiceArr = imgService.split("/");

            // 服务名称
            String imgServiceName = imgServiceArr[0];
            // 服务值
            String imgServiceValue = imgServiceArr[1];

            if (imgServiceName.equals("thumbnail")) {
                //压缩服务
                list.add(new ImgTaskThumbnail(imgServiceValue,imgSrc));

            } else if (imgServiceName.equals("rotate")) {
                //旋转服务
                list.add(new ImgTaskRotate(imgServiceValue,imgSrc));

            }
        }
        threadLocal.set(list);// 加入
    }


    /**
     * 执行
     */
    public List<String> executeQueue() {
        List<String> list1 = new ArrayList<>();
        List<ImgTask> threadList = threadLocal.get();
        for (ImgTask task : threadList) {
            list1.add(task.execute());
        }
        return list1;
    }
}
