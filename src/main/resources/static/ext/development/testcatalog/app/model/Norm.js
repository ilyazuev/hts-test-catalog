Ext.define('TestCatalog.model.Norm', {
	extend : 'Ext.data.Model',
	alias : 'model.norm',
	fields : [ 'id', 'name', 'sampleSize', 'ageRestrictions', 'dataSource', 'default' ],
	
	proxy : {
		type: 'rest',
		url: '/rest/test/{testId}/norms',
		reader : {
			type : 'json',
			rootProperty : '' //rootProperty : '_embedded.norm'
		}
	}
});
