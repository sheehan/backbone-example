modules = {
    layout {
        dependsOn 'jquery'
        resource url:'js/lib/jquery.layout-latest.js'
        resource url:'css/lib/layout-default-latest.css'
    }
    app {
        dependsOn 'jquery, layout'
        defaultBundle false
        resource url: 'js/lib/underscore-min.js'
        resource url: 'js/lib/backbone-min.js'
        resource url: 'js/application.js'
        resource url:'less/application.less',attrs:[rel: "stylesheet/less", type:'css']
    }
}