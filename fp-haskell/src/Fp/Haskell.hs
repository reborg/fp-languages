module Fp.Haskell where

import Data.Function.Memoize (memoize)

p :: Int -> Int
p = p

test :: Int -> Int -> Int
test x y
  | x == 0 = 0
  | otherwise = y

bigSum :: Int -> Int
bigSum n = sum [0..pred n]

bigSumMemo :: Int -> Int
bigSumMemo = memoize bigSum

myGreatSum :: Int -> Int -> Int
myGreatSum a b = a + b

unroll1 :: Int -> (Int -> Int)
unroll1 a = myGreatSum a

unroll2 :: (Int -> (Int -> Int))
unroll2 = myGreatSum
