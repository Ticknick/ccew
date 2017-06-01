package com.system.ccew.token;

/**
 * @author finderlo
 * @date 15/05/2017
 */
public interface TokenManager {
    TokenModel createToken(int userId);

     boolean checkToken(TokenModel tokenModel);

    TokenModel getToken(String authentication);

    void deleteToken(int userId);

}
