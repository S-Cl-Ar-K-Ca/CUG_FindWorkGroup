#include <iostream>
#include <random>
#include <vector>
#include <stack>
#include <iomanip>

using namespace std;

struct BTreeNode{
    BTreeNode(int data = 0):_data(data), plchild(nullptr),prchild(nullptr){}

    int _data;
    BTreeNode *plchild;
    BTreeNode *prchild;
};

BTreeNode* random_btree_generator( const int cnt = 10 ){
    default_random_engine dr_engine;
    uniform_int_distribution<> ui_dbtion(0,1000);

    BTreeNode *root = new BTreeNode();
    vector< BTreeNode* > vpbtn{ root };//利用vector来保存生成的叶子节点指针
    for( int i = 0; i < cnt; ++i ){
        int rdom  = ui_dbtion(dr_engine); //生成一个随机数
        auto iter = vpbtn.begin()+ rdom % vpbtn.size();//随机指向一个叶子节点指针

        BTreeNode *pbtn   = *iter;        // vpbtn链表中至少有一个叶子节点指针
        BTreeNode *pleft  = nullptr;
        BTreeNode *pright = nullptr;

        vpbtn.erase(iter);//已经是非叶子节点了，从vector中移除

        switch( rdom % 3 ){
        case 0:
            pleft = new BTreeNode( ui_dbtion(dr_engine) );
            vpbtn.push_back( pleft );
            break;
        case 1:
            pright = new BTreeNode( ui_dbtion(dr_engine) );
            vpbtn.push_back( pright );
            break;
        case 2:
            pleft = new BTreeNode( ui_dbtion(dr_engine) );
            vpbtn.push_back( pleft );
            pright = new BTreeNode( ui_dbtion(dr_engine) );
            vpbtn.push_back( pright );
            break;
        default:;
        }
        pbtn->plchild = pleft;
        pbtn->prchild = pright;
    }
    return root;
}

void btree_destructor( BTreeNode *root ){
    if( root == nullptr )
        return ;
    btree_destructor( root->plchild );
    btree_destructor( root->prchild );
    delete root;
}

void display_traversal_result( vector<int> &tresult ){
    for( auto iter = tresult.begin(); iter != tresult.end(); ++iter ){
        cout << right << setw(4) << *iter << ' ';
        if( !((iter - tresult.begin() + 1) % 10) )
            cout << endl;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////
//递归     recursive
//非递归   non-recursive
//前序遍历 preorder traversal
//前序遍历递归算法 将遍历结果保存到一个 vector 中
void recursive_preorder_traversal(BTreeNode *root, vector<int> &result ){
    if( root == nullptr )
        return;
    result.push_back( root->_data );
    recursive_preorder_traversal(root->plchild, result);
    recursive_preorder_traversal(root->prchild, result);
    return;
}

//前序遍历非递归算法
void non_recursive_preorder_traversal(BTreeNode *root, vector<int> &result ){
    BTreeNode *pbtn = root;
    stack<BTreeNode*> spbtn;
    while( pbtn != nullptr || !spbtn.empty() ){
        while( pbtn != nullptr ){
            result.push_back( pbtn->_data );
            spbtn.push( pbtn );
            pbtn = pbtn->plchild;

        }
        if( !spbtn.empty() ){
            pbtn = spbtn.top();
            spbtn.pop();
        }
        if( pbtn != nullptr )
            pbtn = pbtn->prchild;
    }
    return;
}

//验证代码
void dlr_test( BTreeNode *root ){
    vector< int > rresutt;
    vector< int > nrresult;

    cout << "前序递归遍历结果如下:" << endl;
    recursive_preorder_traversal(root, rresutt);
    display_traversal_result( rresutt );

    cout <<"\n\n前序非递归遍历结果如下:" << endl;
    non_recursive_preorder_traversal(root, nrresult);
    display_traversal_result(nrresult);

    cout << endl << endl;
    if( rresutt == nrresult ){
        cout << "递归算法与非递归算法遍历结果一样！" << endl;
    }else {
        cout << "递归算法与非递归算法遍历结果不一样！" << endl;
    }
    return;
}


////////////////////////////////////////////////////////////////////////////////////////////
//递归     recursive
//非递归   non-recursive
//中序遍历 inorder traversal
//中序遍历递归算法，将遍历结果保存到一个 vector 中
void recursive_inorder_traversal( BTreeNode *root, vector<int> &result ){
    if( root == nullptr )
        return;
    recursive_inorder_traversal(root->plchild, result);
    result.push_back( root->_data );
    recursive_inorder_traversal(root->prchild, result);
}

//中序遍历非递归算法，将遍历结果保存到一个 vector 中
void non_recursive_inorder_traversal( BTreeNode *root, vector<int> &result ){
    BTreeNode *pbtn = root;
    stack<BTreeNode*> spbtn;
    while( pbtn != nullptr || !spbtn.empty() ){
        while( pbtn != nullptr ){
            spbtn.push( pbtn );
            pbtn = pbtn->plchild;
        }
        if( !spbtn.empty() ){
            pbtn = spbtn.top();
            spbtn.pop();
            result.push_back( pbtn->_data );
        }
        if( pbtn != nullptr )
            pbtn = pbtn->prchild;
    }
    return;
}

//验证代码
void ldr_test( BTreeNode *root ){
    vector< int > rresutt;
    vector< int > nrresult;

    cout << "中序递归遍历结果如下:" << endl;
    recursive_inorder_traversal(root, rresutt);
    display_traversal_result( rresutt );

    cout <<"\n\n中序非递归遍历结果如下:" << endl;
    non_recursive_inorder_traversal(root, nrresult);
    display_traversal_result(nrresult);

    cout << endl << endl;
    if( rresutt == nrresult ){
        cout << "递归算法与非递归算法遍历结果一样！" << endl;
    }else {
        cout << "递归算法与非递归算法遍历结果不一样！" << endl;
    }
    return;
}


////////////////////////////////////////////////////////////////////////////////////////////
//递归     recursive
//非递归   non-recursive
//后序遍历 postorder traversal
//后序遍历递归算法，将遍历结果保存到一个 vector 中
void recursive_postorder_traversal( BTreeNode *root, vector<int> &result ){
    if( root == nullptr )
        return;
    recursive_postorder_traversal( root->plchild, result);
    recursive_postorder_traversal( root->prchild, result);
    result.push_back( root->_data );
    return;
}

//后序遍历非递归算法，将遍历结果保存到一个vector 中
void non_recursive_postorder_traversal( BTreeNode *root, vector<int> &result ){
    BTreeNode *pbtn = root;
    stack<bool> visited;
    stack<BTreeNode*> spbtn;
    while( pbtn != nullptr || !spbtn.empty() ){
        while( pbtn != nullptr ){
            spbtn.push( pbtn );
            visited.push( false );
            pbtn = pbtn->plchild;
        }
        if( !spbtn.empty() ){
            bool first = visited.top();
            visited.pop();

            pbtn = spbtn.top();
            spbtn.pop();
            if( first ){
                result.push_back( pbtn->_data );
                pbtn = nullptr;
            }else{
                visited.push( true );
                spbtn.push( pbtn );
            }
        }
        if( pbtn != nullptr )
            pbtn = pbtn->prchild;
    }
    return;
}

//验证代码
void lrd_test( BTreeNode *root ){
    vector< int > rresutt;
    vector< int > nrresult;

    cout << "后序递归遍历结果如下:" << endl;
    recursive_postorder_traversal(root, rresutt);
    display_traversal_result( rresutt );

    cout <<"\n\n后序非递归遍历结果如下:" << endl;
    non_recursive_postorder_traversal(root, nrresult);
    display_traversal_result(nrresult);

    cout << endl << endl;
    if( rresutt == nrresult ){
        cout << "递归算法与非递归算法遍历结果一样！" << endl;
    }else {
        cout << "递归算法与非递归算法遍历结果不一样！" << endl;
    }
    return;
}


////////////////////////////////////////////////////////////////////////////////////////////
int main(){

    BTreeNode *root = random_btree_generator(500);

    dlr_test( root );//前序
    cout << endl << endl << endl << endl;

    ldr_test( root );//中序
    cout << endl << endl << endl << endl;

    lrd_test( root );//后序
    cout << endl << endl << endl << endl;

    btree_destructor(root);
    return 0;
}
