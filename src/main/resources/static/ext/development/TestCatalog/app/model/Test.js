Ext.define('TestCatalog.model.Test', {
	extend: 'Ext.data.Model',
	alias: 'model.test',
	fields: [ 'id', 'fullName', 'name', 'language' ],
	proxy: {
		type: 'rest',
		url: '/test',
		reader: {
			type: 'json',
			rootProperty: '_embedded.test'
		}
	}
});
