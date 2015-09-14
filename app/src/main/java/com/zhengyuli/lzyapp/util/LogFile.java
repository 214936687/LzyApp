package com.zhengyuli.lzyapp.util;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * write log to file
 *
 * @author liangxianhong
 */
public class LogFile {
    private static Boolean MYLOG_WRITE_TO_FILE = true;// 日志写入文件开关
    private static int SDCARD_LOG_FILE_SAVE_DAYS = 7;// sd卡中日志文件的最多保存天数
    private static LogFile logFile = new LogFile();
    private SimpleDateFormat myLogSdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss", Locale.getDefault());// 日志的输出格式
    private SimpleDateFormat mLogfileFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());// 日志文件格式

    private LogFile() {
        // TODO Auto-generated constructor stub
    }

    public static LogFile getLogFile() {
        return logFile;
    }

    private static String getLogDir() {
        String logDir = Environment.getExternalStorageDirectory()
                + File.separator
                + "lzy"
                + File.separator;

        return logDir;
    }

    private static String getLogFileName(String logfileDate) {
        // 新建或打开日志文件
        StringBuilder sb = new StringBuilder();
        String appName = "life";

        sb.append(logfileDate);
        sb.append("_");
        sb.append(appName);
        sb.append(".log");

        return sb.toString();
    }

    /**
     * 得到现在时间前的几天日期，用来得到需要删除的日志文件名
     */
    private static Date getDateBefore() {
        Date nowtime = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(nowtime);
        now.set(Calendar.DATE, now.get(Calendar.DATE)
                - SDCARD_LOG_FILE_SAVE_DAYS);
        return now.getTime();
    }

    /**
     * 打开日志文件并写入日志
     *
     * @return
     **/
    public void writeLog(String tag, String message, int level) {
        if (!MYLOG_WRITE_TO_FILE) {
            return;
        }
        // 新建或打开日志文件
        Date nowtime = new Date();
        String strLogfileDate = mLogfileFormat.format(nowtime);
        String logFileName = getLogFileName(strLogfileDate);
        String needWriteMessage = myLogSdf.format(nowtime) + "    " + level
                + "    " + tag + "    " + message;

        String logDir = getLogDir();

        File sdcardDir = new File(logDir);
        if (sdcardDir.exists() || (!sdcardDir.exists() && sdcardDir.mkdirs())) {
            File file = new File(logDir, logFileName);
            try {
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");//后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
//				FileWriter filerWriter = new FileWriter(file, true);//后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
                BufferedWriter bufWriter = new BufferedWriter(osw);
                bufWriter.write(needWriteMessage);
                bufWriter.newLine();
                bufWriter.close();
                osw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除制定的日志文件
     */
    public void delFile() {// 删除日志文件
        String logfileDate = mLogfileFormat.format(getDateBefore());
        String logDir = getLogDir();

        String strLogFile = getLogFileName(logfileDate);
        File file = new File(logDir, strLogFile);
        if (file.exists()) {
            boolean deleteResult = file.delete();
            DebugLog.logd("file:" + file.getPath() + "->delete result:" + deleteResult);
        }
    }

}

