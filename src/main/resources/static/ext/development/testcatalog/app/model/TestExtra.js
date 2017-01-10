Ext.define('TestCatalog.model.TestExtra', {
	extend : 'Ext.data.Model',
	alias : 'model.testextra',
	fields : [ 'abbr', 'author', 'type', 'duration', 'description', 'quickOverview', 'productDescription' ],
	proxy : {
		type : 'rest',
		url : '/rest/testextra',
		reader : {
			type : 'json',
			rootProperty : ''
		}
	}
});
