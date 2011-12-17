_.templateSettings = { // change underscore templates to use {{val}}
    interpolate: /\{\{(.+?)\}\}/g
};

(function () {

    var Models = {},
        Views = {},
        Collections = {};

    Models.User = Backbone.Model.extend({
        defaults: {},
        urlRoot: '/backbone-example/api/user',
        getDisplayName: function () {
            return this.get('firstName') + this.get('lastName');
        }
    });

    Collections.Users = Backbone.Collection.extend({
        model: Models.User,
        url: '/backbone-example/api/user',
        comparator: function (user) {
            return user.getDisplayName();
        }
    });

    Views.UserDetail = Backbone.View.extend({

        template: _.template($('#user-view').html()),

        events: {
            'change input': '_handleChange',
            'click button.delete': '_handleDeleteClick'
        },

        initialize: function () {
            this.model.bind('destroy', this.destroy, this);
        },

        _handleChange: function (event) {
            this.model.set({
                firstName: this.$('input[name=firstName]').val(),
                lastName: this.$('input[name=lastName]').val(),
                email: this.$('input[name=email]').val()
            });
            this.model.save();
        },

        _handleDeleteClick: function (event) {
            this.model.destroy();
        },

        render: function () {
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        },

        destroy: function () {
            this.remove();
        }
    });

    Views.UserCollection = Backbone.View.extend({

        tagName: 'ul',

        className: 'users',

        initialize: function () {
            this.collection.bind('all', this.render, this);
        },

        render: function () {
            $(this.el).html('');
            this.collection.each(function (user) {
                var view = new Views.UserCollectionItem({ model: user }).render();
                $(this.el).append(view.el);
            }, this);
            return this;
        }
    });

    Views.UserCollectionItem = Backbone.View.extend({

        events: {
            'click': '_handleClick'
        },

        template: _.template($('#user-collection-item-view').html()),

        tagName: 'li',

        render: function () {
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        },

        _handleClick: function (event) {
            event.preventDefault();
            Backbone.history.navigate('show/' + this.model.id, true);
        }
    });

    $(function() { // on load

        $('body').layout({
            west__paneSelector: '.list',
            west__size: 300,
            center__paneSelector: '.detail'
        });

        var users = new Collections.Users();
        users.fetch({
            success: function () {
                var view = new Views.UserCollection({
                    collection: users
                }).render();
                $('.list').append(view.el);

                new (Backbone.Router.extend({
                    routes: {
                        'show/:id': 'show'
                    },

                    show: function (id) {
                        var user = users.get(id);
                        if (user) {
                            var view = new Views.UserDetail({model: user}).render();
                            $('.detail').html(view.el);
                        }
                    }
                }))();

                Backbone.history.start({pushState: false});
            }
        });
    });

})();
