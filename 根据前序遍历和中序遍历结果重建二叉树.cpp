#include <iostream>
#include <vector>
#include <set>
#include <iterator>
#include <random>
#include <iomanip>
using namespace std;

struct BTreeNode{
    int val;
    BTreeNode *left, *right;
    BTreeNode(int v):val(v),left(nullptr),right(nullptr){}
};

BTreeNode* random_btree_generator( const int cnt = 10 ){
    default_random_engine dr_engine;
    uniform_int_distribution<> ui_dbtion(-10000,100000);

    set<int> si;
    while( si.size() < cnt*3 )
        si.insert( ui_dbtion( dr_engine ) );
    set<int>::iterator siter = si.begin();

    BTreeNode *root = new BTreeNode(*siter++);

    vector< BTreeNode* > vpbtn{ root };//利用链表来保存生成的叶子节点指针
    for( int i = 0; i < cnt; ++i ){
        int rdom  = ui_dbtion(dr_engine); //生成一个随机数
        auto iter = vpbtn.begin()+ rdom % vpbtn.size();//随机指向一个叶子节点指针

        BTreeNode *pbtn   = *iter;        // lpbtn链表中至少有一个叶子节点指针
        BTreeNode *pleft  = nullptr;
        BTreeNode *pright = nullptr;

        vpbtn.erase(iter);//已经是非叶子节点了，从vector中移除

        switch( rdom % 3 ){
        case 0:
            pleft = new BTreeNode( *siter++ );
            vpbtn.push_back( pleft );
            break;
        case 1:
            pright = new BTreeNode( *siter++ );
            vpbtn.push_back( pright );
            break;
        case 2:
            pleft = new BTreeNode( *siter++ );
            vpbtn.push_back( pleft );
            pright = new BTreeNode( *siter++ );
            vpbtn.push_back( pright );
            break;
        default:;
        }
        pbtn->left = pleft;
        pbtn->right = pright;
    }
    return root;
}


BTreeNode* btree_rebuilder(vector<int>::iterator dlr_bgiter, vector<int>::iterator dlr_editer,
                           vector<int>::iterator ldr_bgiter, vector<int>::iterator ldr_editer){
    if( dlr_bgiter  == dlr_editer )
        return nullptr;
    auto dlr_iter = dlr_bgiter +1;//前序遍历列表中的左子树
    auto ldr_iter = ldr_bgiter;   //中序遍历列表中的左子树
    while( *ldr_iter != *dlr_bgiter ){//
        ++ dlr_iter;
        ++ ldr_iter;
    }
    //dlr_bgiter+1 dlr_iter 两个迭代器范围组成了前序遍历列表的左子树
    //dlr_iter, dlr_editer 两个迭代器范围组成了前序遍历列表中的右子树。
    //ldr_bgiter, ldr_iter 两个迭代器范围构成了中序遍历中的左子树
    //ldr_iter+1, ldr_editer 两个迭代器范围构成了中序遍历中的右子树

    BTreeNode *root = new BTreeNode(*dlr_bgiter );
    root->left  = btree_rebuilder(dlr_bgiter+1, dlr_iter, ldr_bgiter, ldr_iter);
    root->right = btree_rebuilder(dlr_iter, dlr_editer, ldr_iter+1, ldr_editer);
    return root;
}

void recursive_preorder_traversal(BTreeNode *root, vector<int> &result ){
    if( root == nullptr )
        return;
    result.push_back( root->val );
    recursive_preorder_traversal(root->left, result);
    recursive_preorder_traversal(root->right, result);
    return;
}

void recursive_inorder_traversal( BTreeNode *root, vector<int> &result ){
    if( root == nullptr )
        return;
    recursive_inorder_traversal(root->left, result);
    result.push_back( root->val );
    recursive_inorder_traversal(root->right, result);
}

void display_traversal_result( vector<int> &tresult ){
    for( auto iter = tresult.begin(); iter != tresult.end(); ++iter ){
        cout << right << setw(6) << *iter << ' ';
        if( !((iter - tresult.begin() + 1) % 10) )
            cout << endl;
    }
    cout << endl << endl;
}

void test(){
    BTreeNode *root = random_btree_generator(100);
    vector<int> dlr_res;
    recursive_preorder_traversal(root, dlr_res);
    cout << "recursive_preorder_traversal:" << endl;
    display_traversal_result( dlr_res );

    vector<int> ldr_res;
    recursive_inorder_traversal( root, ldr_res );
    cout << "recursive_inorder_traversal:" << endl;
    display_traversal_result( ldr_res );


    cout << "btree_rebuilder:" << endl;
    root = btree_rebuilder(dlr_res.begin(), dlr_res.end(),
                           ldr_res.begin(), ldr_res.end() );

    vector<int> ndlr_res;
    recursive_preorder_traversal(root, ndlr_res);
    cout << "recursive_preorder_traversal:" << endl;
    display_traversal_result( ndlr_res );

    vector<int> nldr_res;
    recursive_inorder_traversal( root, nldr_res );
    cout << "recursive_inorder_traversal:" << endl;
    display_traversal_result( nldr_res );

}

int main(){
    test();
    return 0;
}
