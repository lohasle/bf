package org.lohas.bf.utils.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 保存文件，没有路径则生成路径
     *
     * @throws java.io.IOException
     */
    public static String SaveFile(String path, String fileName, byte[] bytes) throws IOException {

        File file = createFile(path, fileName);
        FileCopyUtils.copy(bytes, file);

        return file.getAbsolutePath();
    }

    /**
     * 保存时候增加一个时间文件夹
     */
    public static String SaveFileAddTimeFolder(String path, String fileName, byte[] bytes)
            throws IOException {
        String newPath = path + File.separator + new Date().getTime();
        return SaveFile(newPath, fileName, bytes);
    }

    public static File createFileByAddTimeFolder(String path, String fileName) {
        String newPath = path + File.separator + new Date().getTime();
        File file = createFile(newPath, fileName);
        return file;
    }

    public static File createFile(String path, String fileName) {
        logger.debug("path:" + path);
        String[] paths = path.split(Pattern.quote(File.separator));
        // 改变数组存储
        for (int i = 0; i < paths.length; i++) {
            logger.debug("paths.length:" + paths.length);
            logger.debug("i:" + i);
            if (i > 0) {
                paths[i] = paths[i - 1] + File.separator + paths[i];
            }

            logger.debug("paths[i]:" + paths[i]);
            // 生成路径
            File pathFile = new File(paths[i]);

            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
        }

        String pathAndName = "";

        if (path.endsWith(File.separator)) {
            pathAndName = path + fileName;
        } else {
            pathAndName = path + File.separator + fileName;
        }

        File pathAndNameFile = new File(pathAndName);

        return pathAndNameFile;
    }

    /**
     * 字符保存文件
     *
     * @param content
     * @param filePath
     */
    public static void saveStringToFile(String content, String filePath) {
        FileOutputStream fo = null;
        PrintWriter prWriter = null;
        try {
            fo = new FileOutputStream(filePath);
            prWriter = new PrintWriter(fo);
            prWriter.write(content);
            prWriter.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            saveColeCloseable(prWriter);
        }
    }

    /**
     * 以字节二进制 保存到文件
     *
     * @param content
     * @param filePath
     */
    public static void saveByteToFile(byte[] content, String filePath) {
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(filePath);
            fo.write(content);
            fo.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            saveColeCloseable(fo);
        }
    }


    /**
     * 保存文件
     * @param in
     * @param filePath
     */
    public static void saveInputStreamToFile(InputStream in, String filePath) {
        FileOutputStream fo = null;
        int BUFFER = 1024;
        try {
            fo = new FileOutputStream(filePath);
            byte[] b = new byte[BUFFER];
            int len = 0;
            while((len=in.read(b))!= -1){
                fo.write(b,0,len);
            }
            fo.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            saveColeCloseable(in);
            saveColeCloseable(fo);
        }
    }

    /**
     * 读取文件到字符
     *
     * @param filePath
     * @return
     */
    public static String readFileToString(String filePath) {
        FileReader fr = null;
        try {
            char data[] = new char[1024];
            fr = new FileReader(filePath);
            int num;
            StringBuffer sb = new StringBuffer();
            while ((num = fr.read(data)) != -1) {
                String str = new String(data, 0, num);
                sb.append(str);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            saveColeCloseable(fr);
        }
        return null;
    }

    /**
     * 安全关闭
     *
     * @param clo
     */
    public static void saveColeCloseable(Closeable clo) {
        if (clo != null) {
            try {
                clo.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 安全关闭
     *
     * @param clo []
     */
    public static void saveColeCloseable(Closeable... clo) {
        for (Closeable c : clo) {
            if (c != null) {
                try {
                    c.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 得到一个文件目录下的文件列表
     *
     * @param dir
     * @return
     */
    public static File[] getFileDirList(String dir) {
        File file = new File(dir);
        if (file.exists() && file.isDirectory()) {
            return file.listFiles();
        }
        return new File[]{file};
    }
    /**
     * 得到相对rootpath的路径
     *
     * @param filePath
     * @return
     */
    public static String getRelative(String rootPath, String filePath) {
        String str = filePath.replace(rootPath, "");
        if (str.indexOf(File.separator) > -1) {
            return str.substring(str.indexOf(File.separator) + 1, str.length());
        } else {
            return str;
        }
    }

    /**
     * 重命名
     *
     * @param fileName
     * @param withFileName
     */
    public static void renameFile(String fileName, String withFileName) {
        File file = new File(fileName);
        file.renameTo(new File(withFileName));
    }

    /**
     * 删除文件夹
     *
     * @param strDir
     * @return
     */
    public static boolean removeDir(String strDir) {
        File rmDir = new File(strDir);
        if (rmDir.isDirectory() && rmDir.exists()) {
            String[] fileList = rmDir.list();

            for (int i = 0; i < fileList.length; i++) {
                String subFile = strDir + File.separator + fileList[i];
                File tmp = new File(subFile);
                if (tmp.isFile())
                    tmp.delete();
                else if (tmp.isDirectory())
                    removeDir(subFile);
            }
            rmDir.delete();
        } else {
            return false;
        }
        return true;
    }

    /**
     * 移动文件到文件夹
     *
     * @param strSourceFileName 指定的文件全路径名
     * @param strDestDir        移动到指定的文件夹中
     * @return
     */
    public static boolean moveFile(String strSourceFileName, String strDestDir) {
        if (copyTo(strSourceFileName, strDestDir))
            return delete(strSourceFileName);
        else
            return false;
    }

    /**
     * 删除指定的文件
     *
     * @return
     */
    public static boolean delete(String strFileName) {
        File fileDelete = new File(strFileName);
        if (!fileDelete.exists() || !fileDelete.isFile()) {
            logger.debug(strFileName + "不存在!");
            return false;
        }
        return fileDelete.delete();
    }

    /**
     * 拷贝文件 到指定的文件夹
     *
     * @param strSourceFileName 指定的文件全路径名
     * @param strDestDir        移动到指定的文件夹
     * @return
     */
    public static boolean copyTo(String strSourceFileName, String strDestDir) {
        File fileSource = new File(strSourceFileName);
        File fileDest = new File(strDestDir);
        // 如果源文件不存或源文件不是文件夹
        if (!fileSource.exists() || !fileSource.isFile()) {
            logger.debug("源文件[" + strSourceFileName + "],不存在或是文件夹!");
            return false;
        }
        // 如果目标文件夹不存在
        if (!fileDest.isDirectory() || !fileDest.exists()) {
            if (!fileDest.mkdirs()) {
                logger.debug("目录文件夹不存，在创建目标文件夹时失败!");
                return false;
            }
        }
        FileInputStream fileInput = null;
        FileOutputStream fileOutput = null;
        try {
            String strAbsFilename = strDestDir + File.separator + fileSource.getName();
            fileInput = new FileInputStream(strSourceFileName);
            fileOutput = new FileOutputStream(strAbsFilename);
            logger.debug("开始拷贝文件");
            int count = -1;
            byte[] data = new byte[1024];
            while (-1 != (count = fileInput.read(data, 0, 1024))) {
                fileOutput.write(data, 0, count);
            }
            logger.debug("拷贝文件成功!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            saveColeCloseable(fileInput, fileOutput);
        }
    }

    /**
     * 写入流到文件
     *
     * @param input    流
     * @param file     文件
     * @param buffSize 可选 缓存区大小 buffSize[0]
     * @return
     * @throws java.io.IOException
     */
    public static boolean saveStreamToFile(InputStream input, File file, int... buffSize)
            throws IOException {
        FileOutputStream fileOutput = null;
        try {
            fileOutput = new FileOutputStream(file);
            logger.debug("写入文件");
            int count = -1;
            byte[] data = (buffSize != null && buffSize.length > 0) ? new byte[buffSize[0]]
                    : new byte[1024];
            while (-1 != (count = input.read(data, 0, 1024))) {
                fileOutput.write(data, 0, count);
            }
            logger.debug("拷贝文件成功!");
            return true;
        } finally {
            saveColeCloseable(input, fileOutput);
        }
    }

    /**
     * 复制文件夹
     * 将sourceFolder文件夹下的内容复制到destinationFolder文件夹下
     * 如destinationFolder文件夹不存在则自动创建
     *
     * @param sourceFolder      源文件夹 如：C:\\aaa
     * @param destinationFolder 目标文件夹 D:\\java
     * @throws java.io.IOException
     */
    public static void copyFolder(String sourceFolder, String destinationFolder) throws IOException {
        new File(destinationFolder).mkdirs(); // 如果文件夹不存在 则建立新文件夹
        File a = new File(sourceFolder);
        String[] file = a.list();
        File temp = null;
        for (int i = 0; i < file.length; i++) {
            if (sourceFolder.endsWith(File.separator)) {
                temp = new File(sourceFolder + file[i]);
            } else {
                temp = new File(sourceFolder + File.separator + file[i]);
            }
            if (temp.isFile()) {
                FileInputStream input = new FileInputStream(temp);
                FileOutputStream output = new FileOutputStream(destinationFolder + File.separator
                        + (temp.getName()).toString());
                byte[] b = new byte[1024 * 5];
                int len;
                while ((len = input.read(b)) != -1) {
                    output.write(b, 0, len);
                }
                output.flush();
                output.close();
                input.close();
            }
            if (temp.isDirectory()) {// 如果是子文件夹
                copyFolder(sourceFolder + File.separator + file[i], destinationFolder
                        + File.separator + file[i]);
            }
        }
    }


    /**
     * 得到文件名和文件后缀名
     *
     * @param filePath
     * @return
     * @throws java.io.FileNotFoundException
     * @author 付乐
     */
    public static String[] getFileNameAndExt(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (file.isDirectory()) {
            throw new FileNotFoundException(filePath + " 不是一个文件");
        }
        String[] result_arr = new String[2];
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        result_arr[0] = fileName.substring(0, index);
        result_arr[1] = fileName.substring(index + 1);
        return result_arr;
    }


    /**
     * 得到文件名和文件后缀名
     *
     * @param file
     * @return
     * @throws java.io.FileNotFoundException
     * @author 付乐
     */
    public static String[] getFileNameAndExt(File file) {
        String[] result_arr = new String[2];
        String fileName = file.getName();
        int index = fileName.indexOf(".");
        result_arr[0] = fileName.substring(0, index);
        result_arr[1] = fileName.substring(index + 1);
        return result_arr;
    }


    /**
     * @return
     * @功能说明:得到系统缓存目录(用户目录) .
     * @author fule
     * 2013-10-11 fule
     */
    public static String getSysTempPath() {
        String userDir = System.getProperty("user.home");
        return userDir;
    }


    /**
     * @return
     * @功能说明:得到文件名 .
     * 返回   jpg 等
     * @author fule
     */
    public static String getFileExtName(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length()).toLowerCase();
    }


    /**
     * @return todo 检测文件是否是音频
     */
    public static boolean isAudio(String filePath) {
        String str = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length()).toLowerCase();
        return "amr".equalsIgnoreCase(str);
    }

    /**
     * @return todo 检测文件是否是图片
     */
    public static boolean isImg(String filePath) {
        String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length()).toLowerCase();
        Pattern p = Pattern.compile("jpg|png|gif|bmp|jpeg");
        Matcher matcher = p.matcher(fileType);
        return matcher.matches();
    }



    /**
     * @return 如果图片存在  返回图片地址  如果图片不存在 返回null
     */
    public static String getFileStr(String basePath,String filePath) {
        File file = new File(basePath+filePath);
        if(file.exists()){
            return filePath;
        }
        return null;
    }

}
