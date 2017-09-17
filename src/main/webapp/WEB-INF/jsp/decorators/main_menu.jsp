<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
  <title></title>
  <link rel="stylesheet" href="/static/css/main_menu.css">
  <sitemesh:write property='head'/>
</head>
<body>

<div class="shy-projects am-animation-fade">
  <div class="am-container">
    <nav class="am-fl">
      <a href="javascript:void(0)" class="active">作品列表</a>
      <a href="javascript:void(0)" target="_blank">我们的博客</a>
    </nav>
    <nav class="am-fr">
      <a href="javascript:void(0)" target="_blank"><span class="am-icon-comments-o"></span> 联系我们</a>
    </nav>
  </div>
</div>


<header class="am-topbar am-topbar-inverse am-animation-fade" data-am-sticky="{animation: 'slide-top'}">
  <div class="am-container">
    <h1 class="am-topbar-brand">
      <a href="#">山腰儿工作室</a>
    </h1>
    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#nav-level-2'}">
      <span class="am-sr-only">导航切换</span>
      <span class="am-icon-bars"></span>
    </button>

    <div class="am-collapse am-topbar-collapse am-topbar-right" id="nav-level-2">
      <ul class="am-nav am-nav-pills am-topbar-nav">
        <li class="am-active"><a href="#">社交类</a></li>
        <li><a href="#">电商类</a></li>
        <li><a href="#">企业网站类</a></li>
      </ul>
    </div>
  </div>
</header>
<sitemesh:write property="body"/>
</body>
</html>
