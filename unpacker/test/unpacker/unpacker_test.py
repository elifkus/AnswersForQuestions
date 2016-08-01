'''
Created on 25 Tem 2016

@author: elif
'''
import unittest
from unpacker import arrayunpacker

class Test(unittest.TestCase):

    def testUnpackArray1(self):
        arr = [[1,2,[3]],4]
        output = arrayunpacker.unpack_array(arr)
        expected = [1,2,3,4]
        self.assertEqual(output, expected)

    def testUnpackArray2(self):
        arr = [1,2,3,4]
        output = arrayunpacker.unpack_array(arr)
        expected = [1,2,3,4]
        self.assertEqual(output, expected)

    def testUnpackArray3(self):
        arr = []
        output = arrayunpacker.unpack_array(arr)
        expected = []
        self.assertEqual(output, expected)

    def testUnpackArray4(self):
        arr = [[[[1], 2], 3], 4]
        output = arrayunpacker.unpack_array(arr)
        expected = [1,2,3,4]
        self.assertEqual(output, expected)
     
    def testUnpackArray5(self):
        arr = [1,[ 2, [3, [4]]]]
        output = arrayunpacker.unpack_array(arr)
        expected = [1,2,3,4]
        self.assertEqual(output, expected)
        
    def testUnpackArray6(self):
        arr = [1,[ 2, [3, [4]]], 1,[ 2, [3, [4]]], 1,[ 2, [3, [4]]], 1,[ 2, [3, [4]]], 1,[ 2, [3, [4]]]]
        output = arrayunpacker.unpack_array(arr)
        expected = [1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4]
        self.assertEqual(output, expected)

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()