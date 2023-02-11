INSERT INTO tasklist
SELECT
    '0001',
    'プロになるJavaを通読する',
    '2023-02-01',
    TRUE
WHERE
    NOT EXISTS (
        SELECT 1 FROM tasklist WHERE id='0001'
    );

INSERT INTO tasklist
SELECT
    '0002',
    'プロになるJavaのサンプルWebアプリを実装する',
    '2023-02-07',
    TRUE
WHERE
    NOT EXISTS (
        SELECT 1 FROM tasklist WHERE id='0002'
    );

INSERT INTO tasklist
SELECT
    '0003',
    'ツイッタークローンのver1.0を完成させる',
    '2023-02-20',
    FALSE
WHERE
    NOT EXISTS (
        SELECT 1 FROM tasklist WHERE id='0003'
    );

/* m_user */
INSERT INTO m_user
SELECT
    'US00000001'
    , 'Yuichi Okii'
    , 'hoge'
WHERE
    NOT EXISTS (
        SELECT 1 FROM m_user WHERE user_id='US00000001'
    );

/* t_user */
INSERT INTO m_user
SELECT
    'US00000002'
    , 'Taro Shiken'
    , 'fuga'
WHERE
    NOT EXISTS (
        SELECT 1 FROM m_user WHERE user_id='US00000002'
    );

/* t_follow */
INSERT INTO t_follow
SELECT
    'FL00000001'
    , 'US00000001'
    , 'US00000002'
WHERE
    NOT EXISTS (
        SELECT 1 FROM t_follow WHERE follow_id='FL00000001'
    );

/* t_microposts */
INSERT INTO t_micropost
SELECT
    'MP00000001'
    , 'micro post 1'
    , 'US00000002'
    , '2023-01-01 00:00:00'
WHERE
    NOT EXISTS (
        SELECT 1 FROM t_micropost WHERE micropost_id='MP00000001'
    );

INSERT INTO t_micropost
SELECT
    'MP00000002'
    , 'micro post 2'
    , 'US00000002'
    , '2023-01-01 01:00:00'
WHERE
    NOT EXISTS (
        SELECT 1 FROM t_micropost WHERE micropost_id='MP00000002'
    );
INSERT INTO t_micropost
SELECT
    'MP00000003'
    , '自分のマイクロポスト1'
    , 'US00000001'
    , '2023-01-01 02:00:00'
WHERE
    NOT EXISTS (
        SELECT 1 FROM t_micropost WHERE micropost_id='MP00000003'
    );

/* m_sequence */
INSERT INTO m_sequence
SELECT
    'micropost_id'
    , 'MP'
    , 100
WHERE
    NOT EXISTS (
        SELECT 1 FROM m_sequence WHERE id_name ='micropost_id'
    );