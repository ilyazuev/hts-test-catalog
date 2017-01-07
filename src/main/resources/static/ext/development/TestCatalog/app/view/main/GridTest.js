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
	},
    dockedItems: {
        dock: 'top',
        xtype: 'toolbar',
        items: [{
            hideLabel: true,
            xtype: 'textfield',
            reference: 'filterField',
        	flex: 1,
        	triggers: {
        		search: {
        			cls: Ext.baseCSSPrefix + 'form-clear-trigger',
    				handler: 'onFilterClearClick'	
        		}
        	},
        	listeners: {
                specialkey: 'onFilterFieldSpecialKey'
            }
        },{
        	 xtype: 'button',
             fieldReference: 'filterField',
             cls : Ext.baseCSSPrefix + 'form-search-trigger',
             height: 35,
             listeners: {
                 click: 'onFilterClick'
             }
                
        }]
    },
	viewConfig: {
		loadMask: false
	}
});
