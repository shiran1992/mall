var initialState = [];
var _ = require('lodash');

function carts(state=initialState,action){
    switch(action.type){
        case 'ADD_TO_CART': 
            var pos = _.findIndex(state,{id: action.payload.id});

            if(pos !== -1){
                state[pos].quantity = state[pos].quantity + 1;
                return [...state];
            }else{
                action.payload.quantity = 1;
                return [...state, action.payload]
            }
        default: 
        return state;

    }
}

export default carts;