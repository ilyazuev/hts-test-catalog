Ext.define('TestCatalog.view.main.PanelTestInfo', {
	extend: 'Ext.panel.Panel',
	xtype : 'paneltestinfo',
	tpl: [
		'<div style="float: right; clear: right; background: #faf9dc; border: 1px solid #d8d7ad; padding: 0.5em 1em; width: 20em; margin: 0.5em 0 1em 1em;">',
			'<p>Author: {author}</p>',
			'<p>Description: {description}</p>',
			'<p>Duration: {duration} minutes</p>',
			'<p>Type: {type}</p>',
		'</div>',
		'<div>',
			'<h1>Quick Overview</h1>',
			'<p>{quickOverview}</p>',
		'</div>',
		'<div>',
			'<h1>Product Description</h1>',
			'<p>{productDescription}</p>',
		'</div>'
	]
/*
	tpl: Ext.dom.Helper.markup([{
		style: 'float: right; clear: right; background: #faf9dc; border: 1px solid #d8d7ad; padding: 0.5em 1em; width: 20em; margin: 0.5em 0 1em 1em;'
		,children: [{
			html: '{author}'
		},{
			html: '{description}'
		},{
			html: '{duration}'
		},{
			html: '{type}'
		}]
	},{
		children: [{
			tag: 'h1',
			html: 'Quick Overview'
		},{
			html: '{quickOverview}'
		}]
	},{
		children: [{
			tag: 'h1',
			html: 'Product Description'
		},{
			html: '{productDescription}'
		}]
	}])
*/
});


