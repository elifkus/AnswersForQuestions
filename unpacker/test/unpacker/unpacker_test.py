'''
Created on 25 Tem 2016

@author: elif
'''
import unittest
from unpacker import arrayunpacker

class Test(unittest.TestCase):

    #[[1,2,[3]],4] → [1,2,3,4]
    def testName(self):
        arr = [[1,2,[3]],4]
        output = arrayunpacker.unpack_array(arr)
        expected = [1,2,3,4]
        self.assertEqual(output, expected)


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()