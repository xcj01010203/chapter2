<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
  <title></title>
  <script src="/static/js/register.js"></script>
  <link rel="stylesheet" href="/static/css/register.css"/>
</head>
<body>
<div class="am-container">
  <div class="am-vertical-align shy-head">
    <div class="am-vertical-align-middle am-animation-scale-up am-text-sm">
      山腰儿工作室
    </div>
  </div>
  <div class="am-g">
    <div class="am-u-md-7 am-u-sm-10 am-u-sm-centered am-radius am-animation-fade am-padding-top-xl shy-body">
      <div class="am-animation-scale-up am-margin-top-xl">
        <p class="am-text-xl am-text-center">欢迎注册</p>
        <!--注册表单-->
        <div class="am-g">
          <div class="am-u-lg-7 am-u-sm-centered">
            <form class="am-form am-form-horizontal">
              <div class="am-form-group">
                <input class="am-input-sm" type="text" placeholder="手机号">
              </div>
              <div class="am-form-group">
                <div class="am-u-sm-6 shy-validate-input">
                  <input class="am-input-sm" type="password" placeholder="验证码">
                </div>
                <button class="am-btn am-btn-primary am-btn-sm am-radius am-u-sm-6">获取验证码</button>
              </div>
              <div class="am-form-group">
                <input class="am-input-sm" type="text" placeholder="密码">
              </div>
              <div class="am-form-group">
                <input class="am-input-sm" type="text" placeholder="确认密码">
              </div>
              <button type="submit"
                      class="am-btn am-btn-primary am-btn-block am-btn-sm am-margin-bottom-xs am-radius">注册
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
