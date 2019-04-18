package com.example.admin.cloudmusic.Data;

import java.util.List;

public class LoginData {
    /**
     * loginType : 1
     * code : 200
     * account : {"id":1557477934,"userName":"1_18831998610","type":1,"status":0,"whitelistAuthority":0,"createTime":1534508510860,"salt":"[B@2f59dd54","tokenVersion":2,"ban":0,"baoyueVersion":0,"donateVersion":0,"vipType":0,"viptypeVersion":0,"anonimousUser":false}
     * profile : {"userId":1557477934,"vipType":0,"gender":1,"djStatus":0,"backgroundImgId":109951162868128400,"userType":0,"experts":{},"accountStatus":0,"city":130500,"mutual":false,"remarkName":null,"expertTags":null,"authStatus":0,"backgroundUrl":"http://p2.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","province":130000,"defaultAvatar":false,"avatarUrl":"https://p2.music.126.net/xWJ1DlXuRzy18QMidfJlIQ==/109951163464792834.jpg","birthday":-2209017600000,"avatarImgId":109951163464792830,"nickname":"godsins","avatarImgIdStr":"109951163464792834","backgroundImgIdStr":"109951162868128395","detailDescription":"","followed":false,"description":"","signature":"","authority":0,"avatarImgId_str":"109951163464792834","followeds":0,"follows":4,"eventCount":0,"playlistCount":4,"playlistBeSubscribedCount":0}
     * bindings : [{"expired":false,"userId":1557477934,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"18831998610\",\"hasPassword\":true}","url":"","expiresIn":2147483647,"refreshTime":1534508549,"id":6657619819,"type":1},{"expired":false,"userId":1557477934,"tokenJsonStr":"{\"access_token\":\"9CBB5C97FCC0D50DD379383A7864D69E\",\"openid\":\"D7CFFCA29E4636FB7042781C329D24CD\",\"query_authority_cost\":116,\"nickname\":\"//\",\"partnerType\":\"0\",\"expires_in\":7776000,\"login_cost\":294,\"authority_cost\":3181}","url":"","expiresIn":7776000,"refreshTime":1554124333,"id":6657619820,"type":5}]
     */
    private int loginType;
    private int code;
    private AccountBean account;
    private ProfileBean profile;
    private List<BindingsBean> bindings;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class AccountBean {
        /**
         * id : 1557477934
         * userName : 1_18831998610
         * type : 1
         * status : 0
         * whitelistAuthority : 0
         * createTime : 1534508510860
         * salt : [B@2f59dd54
         * tokenVersion : 2
         * ban : 0
         * baoyueVersion : 0
         * donateVersion : 0
         * vipType : 0
         * viptypeVersion : 0
         * anonimousUser : false
         */
        private String id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private long createTime;
        private String salt;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private int viptypeVersion;
        private boolean anonimousUser;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(int viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }
    }

    public static class ProfileBean {
        /**
         * userId : 1557477934
         * vipType : 0
         * gender : 1
         * djStatus : 0
         * backgroundImgId : 109951162868128400
         * userType : 0
         * experts : {}
         * accountStatus : 0
         * city : 130500
         * mutual : false
         * remarkName : null
         * expertTags : null
         * authStatus : 0
         * backgroundUrl : http://p2.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg
         * province : 130000
         * defaultAvatar : false
         * avatarUrl : https://p2.music.126.net/xWJ1DlXuRzy18QMidfJlIQ==/109951163464792834.jpg
         * birthday : -2209017600000
         * avatarImgId : 109951163464792830
         * nickname : godsins
         * avatarImgIdStr : 109951163464792834
         * backgroundImgIdStr : 109951162868128395
         * detailDescription :
         * followed : false
         * description :
         * signature :
         * authority : 0
         * avatarImgId_str : 109951163464792834
         * followeds : 0
         * follows : 4
         * eventCount : 0
         * playlistCount : 4
         * playlistBeSubscribedCount : 0
         */
        private int userId;
        private int vipType;
        private int gender;
        private int djStatus;
        private long backgroundImgId;
        private int userType;
        private ExpertsBean experts;
        private int accountStatus;
        private int city;
        private boolean mutual;
        private Object remarkName;
        private Object expertTags;
        private int authStatus;
        private String backgroundUrl;
        private int province;
        private boolean defaultAvatar;
        private String avatarUrl;
        private String birthday;
        private long avatarImgId;
        private String nickname;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String detailDescription;
        private boolean followed;
        private String description;
        private String signature;
        private int authority;
        private String avatarImgId_str;
        private int followeds;
        private int follows;
        private int eventCount;
        private int playlistCount;
        private int playlistBeSubscribedCount;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public int getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }

        public static class ExpertsBean {
        }
    }

    public static class BindingsBean {
        /**
         * expired : false
         * userId : 1557477934
         * tokenJsonStr : {"countrycode":"","cellphone":"18831998610","hasPassword":true}
         * url :
         * expiresIn : 2147483647
         * refreshTime : 1534508549
         * id : 6657619819
         * type : 1
         */
        private boolean expired;
        private int userId;
        private String tokenJsonStr;
        private String url;
        private int expiresIn;
        private int refreshTime;
        private long id;
        private int type;

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
