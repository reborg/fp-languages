module Fp.HighOrderSpec (main, spec) where

import Test.Hspec
import Fp.HighOrder

main :: IO ()
main = hspec spec

tickets :: [String]
tickets = ["QA123A3", "ZR2345Z", "GT4535A"]

spec :: Spec
spec =
  describe "winners at the lottery" $ do
    it "always gives a small prize" $
      results tickets 0 `shouldBe` show ["winner 1: (\"QA123A3\",10)\n", "winner 2: (\"ZR2345Z\",10)\n", "winner 3: (\"GT4535A\",10)\n"]
    it "not more than a total of 100 is distributed for larger prizes" $
      results tickets 200 `shouldBe` show ["winner 1: (\"QA123A3\",50)\n", "winner 2: (\"ZR2345Z\",30)\n", "winner 3: (\"GT4535A\",20)\n"]
