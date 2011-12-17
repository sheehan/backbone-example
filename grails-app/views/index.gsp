<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>backbone.js demo</title>
  <r:require modules="app"/>
</head>

<body>

<script type="text/template" id="user-view">
  <div class="detail">

    <div class="img-wrapper"><img src="http://www.gravatar.com/avatar/{{emailMd5Hash}}?d=mm&s=200"/></div>
    <div class="fields">
      <ul>
        <li><label>First Name</label><input type="text" name="firstName" value="{{firstName}}"></li>
        <li><label>Last Name</label><input type="text" name="lastName" value="{{lastName}}"></li>
        <li><label>Email</label><input type="text" name="email" value="{{email}}"></li>
        <li><label>&nbsp;</label><button class="delete" href="#"><img src="${resource(dir: 'images', file: 'cross.png')}" /> Delete</button></li>
      </ul>
    </div>
  </div>
</script>

<script type="text/template" id="user-collection-item-view">
  <img src="http://www.gravatar.com/avatar/{{emailMd5Hash}}?d=mm&s=40" />
  <span class="name">{{firstName}} {{lastName}}</span>
</script>

<div class="list"></div>
<div class="detail"></div>
</body>
</html>