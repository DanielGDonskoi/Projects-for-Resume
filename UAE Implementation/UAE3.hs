module UAE3 where
    data T = 
        --Truthiness
        -- | Falsiness
        --Zero
        IfThenElse T T T
        | Succ T
        | Pred T
        | IsZero T
        | Val Value
        deriving (Show,Eq)

    data Value = Truthiness | Falsiness | NValue NumericValue
                deriving (Show,Eq)
    data NumericValue = Zero | NVSucc NumericValue 
                deriving (Show,Eq)

    bsos :: T ->  T
    --ssos (Succ t)= Val(NValue(NVSucc t))
    --ssos (Succ t)= (Succ Zero)
    --ssos d = d
    --ssos (Succ e) = e
    --Reflexive stuff DONE
    bsos (Val Truthiness) = (Val Truthiness)
    bsos (Val Falsiness) = (Val Falsiness)
    bsos (Val (NValue Zero)) = (Val (NValue Zero))
    bsos (IfThenElse (Val Truthiness) a b) = bsos a
    bsos (IfThenElse (Val Falsiness) a b) = bsos b
    bsos (IfThenElse q u v) = bsos (IfThenElse (bsos q) (bsos u) (bsos v))
    bsos (Succ (Val (NValue a))) = bsos (Val (NValue (NVSucc a)))
    bsos (Val (NValue (NVSucc a))) = (Val (NValue (NVSucc a)))
    bsos (Pred (Val (NValue Zero))) = (Val (NValue Zero))
    bsos (Pred (Val (NValue (NVSucc a)))) = bsos (Val (NValue a))
    bsos (Succ(Pred t)) = (bsos t)
    bsos (Pred(Succ t)) = (bsos t)
    bsos (Succ a) = Succ (bsos a)
    bsos (Pred a) = Pred (bsos a)
    --Get rid of these two, redundant
    bsos (IsZero (Val (NValue Zero)))= (Val Truthiness)
    bsos (IsZero (Val (NValue (NVSucc a)))) = (Val Falsiness)
    bsos (IsZero (a)) = IsZero(bsos a)

    --ssos (IfThenElse ((Val Truthiness)) a b) = a
    --ssos (IfThenElse ((Val Falsiness)) a b) = b
    --ssos (IfThenElse x y z) = (IfThenElse x y z)

    --ssos (Pred (Succ t)) = t
    --ssos (Succ (Pred t)) = t
