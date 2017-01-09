Ext.define('TestCatalog.view.main.TabTest', {
	extend : 'Ext.tab.Panel',
	xtype : 'tabtest',
	
    requires: [
        'TestCatalog.view.main.PanelTestInfo',
    	'TestCatalog.view.main.ViewTestForm',
        'TestCatalog.view.main.GridNorm'
    ],
	
    bind: {
    	title: '{selectedTest.fullName}'
    },
    
    title: 'Test',
	
	items: [{
        tabConfig: {
            title: 'Test Info',
            tooltip: 'test info'
        },
    	items: [{
    			id: 'testInfo',
    			xtype: 'paneltestinfo'
    		},{
    			id: 'testStructure',
    			xtype: 'viewtestform'
    	}]
    }, {
        tabConfig: {
            title: 'Examples',
            tooltip: 'test items examples'
        },
        id: 'testExamples',
        disabled: true
    }, {
        tabConfig: {
            title: 'Norms',
            tooltip: 'test norms'
        },
        items: {
        	xtype: 'gridnorm',
        	id: 'testNorms'
        }
    }],

    listeners: {
        beforetabchange: function(tabs, newTab, oldTab) {
            return true;
        }
    }
});
