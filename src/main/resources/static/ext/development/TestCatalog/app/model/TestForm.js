Ext.define('TestCatalog.model.TestForm', {
	extend : 'Ext.data.Model',
	alias : 'model.testform',
	fields : [ 'id', 'name' ],
	proxy : {
		type: 'rest',
		url: '/test/{testId}/testForms',
		reader : {
			type : 'json',
			rootProperty : '_embedded.testform'
		}
	}
});
