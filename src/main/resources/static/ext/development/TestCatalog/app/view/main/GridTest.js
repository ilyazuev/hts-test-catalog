Ext.define('TestCatalog.view.main.GridTest', {
	extend: 'Ext.grid.Panel',
	xtype: 'gridtest',
	bind: {
        store: '{test}',
        selection: '{selectedTest}'
    },
	title: 'TESTS',
	columns: [ 
		{ text: 'Test Name', dataIndex: 'fullName', flex: 1 }, 
		{ text: '', dataIndex: 'language' }
	],
	listeners: {
		select: 'onGridTestItemSelected'
	}
});
