/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('TestCatalog.Application', {
    extend: 'Ext.app.Application',
    
    name: 'TestCatalog',

	requires: [
        'Ext.data.proxy.Rest'
    ],
	
    stores: [
    ],
    
    launch: function () {
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});

var _buildUrl = Ext.data.proxy.Rest.prototype.buildUrl;
Ext.override(Ext.data.proxy.Rest, {
	buildUrl: function (request) {
		var me = this,
			url = null,
			params = request.getParams();
		if(params) {
			if(params.query) {
				if(me.urlQuery) {
					me.setUrl(me.urlQuery);
				}
			} else if(me.urlBase) {
				me.setUrl(me.urlBase);
			}
			url =_buildUrl.apply(me, arguments);
			var a,
				added = [];
			for(var p in params) {
				a = '{' + p + '}';
				if( url.indexOf(a) >= 0 ) {
					url = url.replace(a, params[p]);
					added.push(p);
				}
			}
			for(var p in added) {
				delete params[added[p]];
			}
		}
        return url || _buildUrl.apply(me, arguments);
	}
});
