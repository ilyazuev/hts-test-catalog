/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('TestCatalog.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main',

    onGridTestItemSelected: function (sender, record) {
    	var testId = record.get('id')
    		,viewModel = this.getViewModel();
    	viewModel.getSchema().getEntity('TestCatalog.model.TestExtra').load(testId, {
    		callback: function() {
    			Ext.getCmp('testInfo').setData( this.getData() );	
    		}
    	});
    	var storeTestform = viewModel.getStore('testform');
    	storeTestform.getProxy().setExtraParam('testId', testId);
    	storeTestform.load(); 
    	var storeNorm = viewModel.getStore('norm');
    	storeNorm.getProxy().setExtraParam('testId', testId);
    	storeNorm.load();    	
    },
    onFilterClearClick: function(textField) {
    	textField.setValue(null);
    	this.loadTestStore();
    },
    onFilterClick: function(button) {
    	this.loadTestStore(this.lookupReference(button.fieldReference).getValue());
    },
    onFilterFieldSpecialKey: function(field, event) {
    	var key = event.getKey();
        if (key === event.ENTER || key == event.TAB) {
            this.loadTestStore(field.getValue());
        }
    },
    loadTestStore: function(query) {
    	var storeTest = this.getViewModel().getStore('test');
    	storeTest.getProxy().setExtraParam('query', query);
    	storeTest.load();
    },
	onStoreTestLoad: function() {
		Ext.defer(function() {
			Ext.getCmp('gridTest').getSelectionModel().select(0);
		}, 50);
/*		
		Ext.defer(()=>{
			Ext.getCmp('gridTest').getSelectionModel().select(0);
		}, 50);
*/		
	}
});
