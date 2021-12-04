module UAE1 where
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

    ssos :: T ->  T
    --ssos (Succ t)= Val(NValue(NVSucc t))
    --ssos (Succ t)= (Succ Zero)
    --ssos d = d
    --ssos (Succ e) = e
    --Reflexive stuff DONE
    ssos (Val Truthiness) = (Val Truthiness)
    ssos (Val Falsiness) = (Val Falsiness)
    ssos (Val (NValue Zero)) = (Val (NValue Zero))
    ssos (IfThenElse (Val Truthiness) a b) = ssos a
    ssos (IfThenElse (Val Falsiness) a b) = ssos b
    ssos (IfThenElse q u v) = ssos (IfThenElse (ssos q) (ssos u) (ssos v))
    ssos (Succ (Val (NValue a))) = ssos (Val (NValue (NVSucc a)))
    ssos (Val (NValue (NVSucc a))) = (Val (NValue (NVSucc a)))
    ssos (Pred (Val (NValue Zero))) = (Val (NValue Zero))
    ssos (Pred (Val (NValue (NVSucc a)))) = ssos (Val (NValue a))
    ssos (Succ(Pred t)) = t
    ssos (Pred(Succ t)) = t
    ssos (Succ a) = Succ (ssos a)
    ssos (Pred a) = Pred (ssos a)
    --Get rid of these two, redundant
    ssos (IsZero (Val (NValue Zero)))= (Val Truthiness)
    ssos (IsZero (Val (NValue (NVSucc a)))) = (Val Falsiness)
    ssos (IsZero (a)) = IsZero(ssos a)

    --ssos (IfThenElse ((Val Truthiness)) a b) = a
    --ssos (IfThenElse ((Val Falsiness)) a b) = b
    --ssos (IfThenElse x y z) = (IfThenElse x y z)

    --ssos (Pred (Succ t)) = t
    --ssos (Succ (Pred t)) = t

    eval:: T -> T
    eval a = 
        if a == (ssos a) then (a)
        else (eval (ssos a))