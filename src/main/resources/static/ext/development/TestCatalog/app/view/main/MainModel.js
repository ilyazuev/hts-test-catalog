/**
 * This class is the view model for the Main view of the application.
 */
Ext.define('TestCatalog.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.main',
    
	requires : [ 
		'TestCatalog.model.Test', 
		'TestCatalog.model.TestExtra',
		'TestCatalog.model.TestForm'
	],    

    data: {
        name: 'TestCatalog',
        loremIpsum: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
    }
	
	,stores: {
		test: {
			model: 'TestCatalog.model.Test',
            autoLoad: true,
        	autoSync: true,
        	pageSize: 0,
        	listeners: {
        		load: 'onStoreTestLoad'
        	}
		}
		,testform: {
			model: 'TestCatalog.model.TestForm',
	        autoLoad: false,
	    	pageSize : 0
		}
	}

	,links: {
		testExtra: {
			type: 'TestCatalog.model.TestExtra'
			,create: true
		}
	}
});
