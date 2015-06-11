module Fp.InfiniteStreamSpec (main, spec) where

import Test.Hspec
import Fp.InfiniteStream

main :: IO ()
main = hspec spec

spec :: Spec
spec =
  describe "lottery tickets generator" $
    it "can print as many as you like" $
      length (take 3 ticketGen) `shouldBe` 3
