package com.library.LibraryProject.manager;



import org.springframework.web.multipart.MultipartFile;

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

    void importUsers(MultipartFile multipartFile) throws IOException;
}
