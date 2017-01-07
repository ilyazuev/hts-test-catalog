Ext.define('TestCatalog.view.main.GridNorm', {
	extend: 'Ext.grid.Panel',
	xtype: 'gridnorm',
	bind: {
        store: '{norm}',
        selection: '{selectedNorm}'
    },
    title: 'Available Norms',
	columns: [ 
		{ text: 'Name', dataIndex: 'name', flex: 1 }, 
		{ text: 'Sample Size', dataIndex: 'sampleSize' },
		{ text: 'Age Restrictions', dataIndex: 'ageRestrictions', width: 120 },
		{ text: 'Data Source', dataIndex: 'dataSource' },
		{ text: 'Default', dataIndex: 'default', align: 'center', renderer: function(value) {
		    return value ? '<span style="color: green; font-size: medium;">&#x2714;</span>' : '';
		}}
	],
	viewConfig: {
		loadMask: false
	}
});
