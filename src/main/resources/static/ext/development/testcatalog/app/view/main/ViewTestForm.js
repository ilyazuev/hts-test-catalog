Ext.define('TestCatalog.view.main.ViewTestForm', {
	extend : 'Ext.view.View',
	xtype : 'viewtestform',

	bind: {
        store: '{testform}',
        selection: '{selectedTestForm}'
    },
    tpl: [
    	'<div>',
			'<h1>Test Structure</h1>',
		'</div>',
		'<ul>',
			'<tpl for=".">',
        		'<li>{name}</li>',
    		'</tpl>',
		'</ul>'
    ],
    itemSelector: 'li',
	loadMask: false
});
