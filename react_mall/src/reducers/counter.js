var initialState = {
    count : 0,
    count1: 0,
    lists : {
        rows : [],
        total: 0
    }
}

function reducer(state=initialState,action){
    switch(action.type){
        case 'INCREASE': 
            return {...state,count:state.count+1}
        case 'DECREASE': 
            return {...state,count1:state.count1-1}
        case 'GETLISTS': 
            return {...state,lists: action.payload }
        default: 
            return state;
    }
}

export default reducer;