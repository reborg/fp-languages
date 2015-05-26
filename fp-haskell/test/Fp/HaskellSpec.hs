module Fp.HaskellSpec (main, spec) where

import Test.Hspec
import Fp.Haskell

main :: IO ()
main = hspec spec

spec :: Spec
spec = do

  describe "infinite recursion" $
    it "doesn't blow up" $
      test 0 (p 1) `shouldBe` 0

  describe "memoization" $ do
    describe "no memo" $
      it "slow as hell" $ do
        putStrLn ".... 1"
        bigSum 10000000 `shouldBe` 49999995000000
    describe "first time" $
      it "still slow" $ do
        putStrLn ".... 2"
        bigSumMemo 10000000 `shouldBe` 49999995000000
    describe "second time" $
      it "flash" $ do
        putStrLn ".... 3"
        bigSumMemo 10000000 `shouldBe` 49999995000000

  describe "currying like a boss" $ do
    it "works the same with two args" $
      myGreatSum 2 3 `shouldBe` 5
    it "can work with only 1" $
      (unroll1 2) 3 `shouldBe` 5
    it "can work with nothing" $
      ((unroll2) 3) 2 `shouldBe` 5
    it "actually you can just throw away those pesky parens" $
      unroll2 3 2 `shouldBe` 5
