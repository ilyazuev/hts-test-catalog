Ext.define('TestCatalog.model.Test', {
	extend: 'Ext.data.Model',
	alias: 'model.test',
	fields: [ 'id', 'fullName', 'name', 'language' ],
	proxy: {
		type: 'rest',
		urlBase: '/test',
		urlQuery: '/test/search/findByNameAndDescriptionsContaining?query={query}',
		reader: {
			type: 'json',
			rootProperty: '_embedded.test'
		}
	}
});
