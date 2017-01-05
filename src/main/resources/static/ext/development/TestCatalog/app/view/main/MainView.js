/**
 * This class is the main view for the application. It is specified in app.js as the
 * "mainView" property. That setting automatically applies the "viewport"
 * plugin causing this view to become the body element (i.e., the viewport).
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('TestCatalog.view.main.MainView', {
    extend: 'Ext.panel.Panel',
    xtype: 'app-main',

    requires: [
        'Ext.plugin.Viewport',
        'Ext.window.MessageBox',

        'TestCatalog.view.main.MainController',
        'TestCatalog.view.main.MainModel',
        'TestCatalog.view.main.GridTest',
        'TestCatalog.view.main.TabTest'
    ],

    controller: 'main',
    viewModel: 'main',

    ui: 'navigation',

    bodyPadding: 5,
    layout: 'border',
    
    defaults: {
        bodyPadding: 20
    },

    items: [{
    	xtype: 'gridtest',
    	id: 'gridTest',
		region: 'west',
		width: 300,
		border: true,
		collapsible: true,
		split: true
    }, {
    	xtype: 'tabtest',
    	region: 'center',
		id: 'testTabs'
    }]
});
