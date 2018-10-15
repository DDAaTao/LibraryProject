package com.library.LibraryProject.manager;


import com.sun.deploy.net.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 文涛
 * 2018年10月15日23:36:56
 * */

public interface UserManager {
    /**
     * 下载所有的用户信息
     * */
    void allUsersDownload(HttpServletResponse httpServletResponse) throws IOException;
}
