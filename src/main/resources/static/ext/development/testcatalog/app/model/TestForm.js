Ext.define('TestCatalog.model.TestForm', {
	extend : 'Ext.data.Model',
	alias : 'model.testform',
	fields : [ 'id', 'name' ],
	proxy : {
		type: 'rest',
		url: '/rest/test/{testId}/testForms',
		reader : {
			type : 'json',
			rootProperty : '' // rootProperty : '_embedded.testform'
		}
	}
});
