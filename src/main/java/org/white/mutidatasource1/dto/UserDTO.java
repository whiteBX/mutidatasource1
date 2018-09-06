package org.white.mutidatasource1.dto;

/**
 * <p>用户数据实体</p >
 *
 * @author baixiong
 * @version $Id: UserDTO.java, v 0.1 2018年09月05日 16:25:00 baixiong Exp$
 */
public class UserDTO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
