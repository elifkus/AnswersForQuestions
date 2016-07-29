'''
Created on 25 Tem 2016

@author: elif
'''
def unpack_array(arr):
    '''
    Function
    '''
    result = []
    
    for item in arr:
        if type(item) is list:
            intermediate_result = unpack_array(item) 
            result.extend(intermediate_result)
        else:
            result.append(item) 
    return result
    
    